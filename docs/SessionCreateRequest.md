

# SessionCreateRequest

Payload to open a new conversation session. The model, system prompt, temperature and thinking flag are locked at creation time and apply to every post in the session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusIds** | **List&lt;UUID&gt;** | IDs of the corpora the session is bound to (UUIDv4). A session may search across several corpora. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the session. Stored as JSONB. |  [optional] |



