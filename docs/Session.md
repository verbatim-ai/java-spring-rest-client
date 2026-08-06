

# Session

Conversation thread bound to a user and to one or more corpora.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier of the session (UUIDv4). |  |
|**userId** | **String** | Identifier of the user who opened the session, as carried by the JWT. Stored as a free-form string so non-UUID identity providers are supported. |  [optional] |
|**corpusIds** | **List&lt;String&gt;** | IDs of the corpora the session is bound to (UUIDv4). |  |
|**model** | **String** | LLM bound to the session. |  |
|**system** | **String** | System prompt the LLM was initialised with. |  [optional] |
|**temperature** | **Double** | Sampling temperature configured on the session. |  [optional] |
|**thinking** | **Boolean** | Whether the model&#39;s *thinking* mode is enabled on this session. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the session. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the session (ISO-8601, UTC). |  |



