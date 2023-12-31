[![](https://jitpack.io/v/dexuby/openai4j.svg)](https://jitpack.io/#dexuby/openai4j)
# openai4j
Easy to use OpenAI API Client in Java.

Requirements:
- Java 17+

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
<dependency>
    <groupId>com.github.dexuby</groupId>
    <artifactId>openai4j</artifactId>
    <version>...</version>
</dependency>
```
Latest version can be found here: https://github.com/dexuby/openai4j/releases

Has been made in a really short amount of time so currently pretty much only supports all the new Beta features like Assistants (and TTS). Method and Class names usually match the API Documentation names.

Supported API features:
- Audio
  - Create speech
- Assistants
  - Full support
- Threads
  - Full support
- Messages
  - Full support
- Runs
  - Full support
- Images
  - Create
    
Example usage:
```java
final OpenAIClient client = new OpenAIClient("<YOUR API KEY>");
final Assistant assistant = client.createAssistant(
    AssistantCreationRequest.builder()
        .model(Model.GPT_4_TURBO)
        .name("Example")
        .description("Just an example assistant.")
        .instructions("You are a helpful assistant.")
        .build()
    ).join();
final Thread thread = client.createThread(ThreadCreationRequest.empty()).join();
client.createMessage(thread.id(),
    MessageCreationRequest.builder()
        .role(Role.USER)
        .content("Hey, can you tell me what time it is in New York?")
        .build()
    ).join();
final Run run = client.createRun(thread.id(),
    RunCreationRequest.builder()
        .assistantId(assistant.id())
        .build()
    ).join();
```

To-do - If you want to contribute you can work on those items:
- Improve/clean up request handling.
- Support for non-Beta API features.
- Support for rate limit headers.
- Better error handling.
- ...
