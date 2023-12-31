package dev.dexuby.openaiclient;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.dexuby.easycommon.external.jetbrains.annotations.NotNull;
import dev.dexuby.openaiclient.assistant.Assistant;
import dev.dexuby.openaiclient.assistant.AssistantCreationRequest;
import dev.dexuby.openaiclient.common.Constants;
import dev.dexuby.openaiclient.common.DeletionStatus;
import dev.dexuby.openaiclient.common.EndPoint;
import dev.dexuby.openaiclient.common.Request;
import dev.dexuby.openaiclient.image.ImageCreationRequest;
import dev.dexuby.openaiclient.image.ImageList;
import dev.dexuby.openaiclient.message.Message;
import dev.dexuby.openaiclient.message.MessageCreationRequest;
import dev.dexuby.openaiclient.message.MessageListQuery;
import dev.dexuby.openaiclient.message.MessageModificationRequest;
import dev.dexuby.openaiclient.run.*;
import dev.dexuby.openaiclient.run.step.RunStep;
import dev.dexuby.openaiclient.run.step.RunStepListQuery;
import dev.dexuby.openaiclient.thread.Thread;
import dev.dexuby.openaiclient.thread.ThreadCreationRequest;
import dev.dexuby.openaiclient.thread.ThreadModificationRequest;
import dev.dexuby.openaiclient.tts.TextToSpeechRequest;
import org.apache.hc.client5.http.classic.methods.HttpDelete;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("deprecation")
public class OpenAIClient {

    private final ExecutorService executorService = Executors.newCachedThreadPool();

    private final String apiKey;

    public OpenAIClient(@NotNull final String apiKey) {

        this.apiKey = apiKey;

    }

    public CompletableFuture<Assistant> createAssistant(@NotNull final AssistantCreationRequest request) {

        final CompletableFuture<Assistant> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.ASSISTANTS, request, Assistant.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Assistant> retrieveAssistant(@NotNull final String assistantId) {

        final CompletableFuture<Assistant> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.ASSISTANTS, assistantId), Assistant.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Thread> createThread(@NotNull final ThreadCreationRequest request) {

        final CompletableFuture<Thread> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.THREADS, request, Thread.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Thread> retrieveThread(@NotNull final String threadId) {

        final CompletableFuture<Thread> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.THREADS, threadId), Thread.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Thread> modifyThread(@NotNull final String threadId, @NotNull final ThreadModificationRequest request) {

        final CompletableFuture<Thread> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId), request, Thread.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<DeletionStatus> deleteThread(@NotNull final String threadId) {

        final CompletableFuture<DeletionStatus> future = new CompletableFuture<>();
        this.deleteAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId), DeletionStatus.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Message> createMessage(@NotNull final String threadId, @NotNull final MessageCreationRequest request) {

        final CompletableFuture<Message> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "messages"), request, Message.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Message> retrieveMessage(@NotNull final String threadId, @NotNull final String messageId) {

        final CompletableFuture<Message> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "messages", messageId), Message.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Message> modifyMessage(@NotNull final String threadId, @NotNull final String messageId, @NotNull final MessageModificationRequest request) {

        final CompletableFuture<Message> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "messages", messageId), request, Message.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<List<Message>> listMessages(@NotNull final String threadId, @NotNull final MessageListQuery query) {

        final CompletableFuture<List<Message>> future = new CompletableFuture<>();
        this.getString(EndPoint.combine(EndPoint.THREADS, threadId, "messages") + query.construct()).thenAccept((content) -> {
            if (content == null) {
                future.complete(null);
                return;
            }
            final List<Message> messages = new ArrayList<>();
            final JsonArray jsonArray = JsonParser.parseString(content).getAsJsonObject().getAsJsonArray("data");
            for (final JsonElement jsonElement : jsonArray)
                messages.add(Constants.GSON.fromJson(jsonElement, Message.class));
            future.complete(messages);
        });

        return future;

    }

    public CompletableFuture<Run> createRun(@NotNull final String threadId, @NotNull final RunCreationRequest request) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs"), request, Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Run> retrieveRun(@NotNull final String threadId, @NotNull final String runId) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId), Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Run> modifyRun(@NotNull final String threadId, @NotNull final String runId, @NotNull final RunModificationRequest request) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId), request, Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<List<Run>> listRuns(@NotNull final String threadId, @NotNull final RunListQuery query) {

        final CompletableFuture<List<Run>> future = new CompletableFuture<>();
        this.getString(EndPoint.combine(EndPoint.THREADS, threadId, "runs") + query.construct()).thenAccept((content) -> {
            if (content == null) {
                future.complete(null);
                return;
            }
            final List<Run> runs = new ArrayList<>();
            final JsonArray jsonArray = JsonParser.parseString(content).getAsJsonObject().getAsJsonArray("data");
            for (final JsonElement jsonElement : jsonArray)
                runs.add(Constants.GSON.fromJson(jsonElement, Run.class));
            future.complete(runs);
        });

        return future;

    }

    public CompletableFuture<Run> submitToolOutputsToRun(@NotNull final String threadId, @NotNull final String runId, @NotNull final ToolOutputSubmitRequest request) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId, "submit_tool_outputs"), request, Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Run> cancelRun(@NotNull final String threadId, @NotNull final String runId) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId, "cancel"), Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<Run> createThreadAndRun(@NotNull final ThreadAndRunCreationRequest request) {

        final CompletableFuture<Run> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.THREADS, "runs"), request, Run.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<RunStep> retrieveRunStep(@NotNull final String threadId, @NotNull final String runId, @NotNull final String stepId) {

        final CompletableFuture<RunStep> future = new CompletableFuture<>();
        this.getJsonObject(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId, "steps", stepId), RunStep.class).thenAccept(future::complete);

        return future;

    }

    public CompletableFuture<List<RunStep>> listRunSteps(@NotNull final String threadId, @NotNull final String runId, @NotNull final RunStepListQuery query) {

        final CompletableFuture<List<RunStep>> future = new CompletableFuture<>();
        this.getString(EndPoint.combine(EndPoint.THREADS, threadId, "runs", runId, "steps") + query.construct()).thenAccept((content) -> {
            if (content == null) {
                future.complete(null);
                return;
            }
            final List<RunStep> runs = new ArrayList<>();
            final JsonArray jsonArray = JsonParser.parseString(content).getAsJsonObject().getAsJsonArray("data");
            for (final JsonElement jsonElement : jsonArray)
                runs.add(Constants.GSON.fromJson(jsonElement, RunStep.class));
            future.complete(runs);
        });

        return future;

    }

    public CompletableFuture<ImageList> createImage(@NotNull final ImageCreationRequest request) {

        final CompletableFuture<ImageList> future = new CompletableFuture<>();
        this.postRequestAndGetJsonObject(EndPoint.combine(EndPoint.IMAGES, "generations"), request, ImageList.class).thenAccept(future::complete);

        return future;

    }

    /**
     * Test implementation
     */

    public CompletableFuture<File> generateTextToSpeech(@NotNull final TextToSpeechRequest request, @NotNull final File targetFile) {

        final CompletableFuture<File> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpPost postRequest = this.populateHeaders(new HttpPost("https://api.openai.com/v1/audio/speech"));
            final StringEntity entity = new StringEntity(
                    Constants.GSON.toJson(request),
                    ContentType.create("application/json", StandardCharsets.UTF_8)
            );
            postRequest.setEntity(entity);
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(postRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                try (final BufferedInputStream bufferedInputStream = new BufferedInputStream(responseEntity.getContent());
                     final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(targetFile))) {
                    int inByte;
                    while ((inByte = bufferedInputStream.read()) != -1)
                        bufferedOutputStream.write(inByte);
                } catch (final Exception ex) {
                    Constants.LOGGER.warn("Failed to generate text to speech", ex);
                }
                future.complete(targetFile);
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to generate text to speech", ex);
                future.complete(null);
            }
        });

        return future;

    }

    /**
     * Test implementation
     */

    public CompletableFuture<BufferedInputStream> generateTextToSpeechStream(@NotNull final TextToSpeechRequest data, @NotNull final File targetFile) {

        final CompletableFuture<BufferedInputStream> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpPost postRequest = this.populateHeaders(new HttpPost("https://api.openai.com/v1/audio/speech"));
            final StringEntity entity = new StringEntity(
                    Constants.GSON.toJson(data),
                    ContentType.create("application/json", StandardCharsets.UTF_8)
            );
            postRequest.setEntity(entity);
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(postRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(responseEntity.getContent());
                future.complete(bufferedInputStream);
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to generate text to speech", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private <T> CompletableFuture<T> postRequestAndGetJsonObject(@NotNull final String address, @NotNull final Request request, @NotNull final Class<T> clazz) {

        final CompletableFuture<T> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpPost postRequest = this.populateHeaders(new HttpPost(address));
            final StringEntity entity = new StringEntity(
                    Constants.GSON.toJson(request),
                    ContentType.create("application/json", StandardCharsets.UTF_8)
            );
            postRequest.setEntity(entity);
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(postRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final String content = EntityUtils.toString(responseEntity);
                final JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
                future.complete(Constants.GSON.fromJson(jsonObject, clazz));
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to post data.", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private CompletableFuture<String> postRequestAndGetString(@NotNull final String address, @NotNull final Request request) {

        final CompletableFuture<String> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpPost postRequest = this.populateHeaders(new HttpPost(address));
            final StringEntity entity = new StringEntity(
                    Constants.GSON.toJson(request),
                    ContentType.create("application/json", StandardCharsets.UTF_8)
            );
            postRequest.setEntity(entity);
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(postRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final String content = EntityUtils.toString(responseEntity);
                future.complete(content);
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to post data.", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private <T> CompletableFuture<T> getJsonObject(@NotNull final String address, @NotNull final Class<T> clazz) {

        final CompletableFuture<T> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpGet getRequest = this.populateHeaders(new HttpGet(address));
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(getRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final String content = EntityUtils.toString(responseEntity);
                final JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
                future.complete(Constants.GSON.fromJson(jsonObject, clazz));
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to read data.", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private CompletableFuture<String> getString(@NotNull final String address) {

        final CompletableFuture<String> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpGet getRequest = this.populateHeaders(new HttpGet(address));
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(getRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final String content = EntityUtils.toString(responseEntity);
                future.complete(content);
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to read data.", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private <T> CompletableFuture<T> deleteAndGetJsonObject(@NotNull final String address, @NotNull final Class<T> clazz) {

        final CompletableFuture<T> future = new CompletableFuture<>();
        this.executorService.submit(() -> {
            final HttpDelete deleteRequest = this.populateHeaders(new HttpDelete(address));
            try (final CloseableHttpClient httpClient = HttpClients.createDefault();
                 final CloseableHttpResponse response = httpClient.execute(deleteRequest)) {
                final HttpEntity responseEntity = response.getEntity();
                final String content = EntityUtils.toString(responseEntity);
                final JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
                future.complete(Constants.GSON.fromJson(jsonObject, clazz));
            } catch (final Exception ex) {
                Constants.LOGGER.warn("Failed to read data.", ex);
                future.complete(null);
            }
        });

        return future;

    }

    private <T extends HttpUriRequestBase> T populateHeaders(@NotNull final T request) {

        request.addHeader("Authorization", "Bearer " + this.apiKey);
        request.addHeader("OpenAI-Beta", "assistants=v1");

        return request;

    }

}
