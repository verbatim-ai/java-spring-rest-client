

# SessionCreateRequest

Payload to open a new conversation session. The model, system prompt, temperature and thinking flag are locked at creation time and apply to every post in the session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusIds** | **List&lt;UUID&gt;** | IDs of the corpora the session is bound to (UUIDv4). A session may search across several corpora. |  |
|**model** | **String** | Name of the LLM used to answer queries in this session. Must be installed on the Ollama runtime. |  |
|**system** | **String** | System prompt sent to the LLM as the first message. Falls back to a default RAG prompt when omitted. |  [optional] |
|**temperature** | **Double** | Sampling temperature. Range and meaning depend on the model — refer to the model&#39;s documentation. |  [optional] |
|**thinking** | **Boolean** | Enable the model&#39;s *thinking* mode. Only honored by models that support it. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the session. Stored as JSONB. |  [optional] |



