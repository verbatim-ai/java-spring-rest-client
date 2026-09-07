

# Thread

Conversation thread bound to a user and to one or more corpora.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the thread (UUIDv4). |  |
|**userId** | **String** | Identifier of the user who opened the thread, as carried by the JWT. Stored as a free-form string so non-UUID identity providers are supported. |  [optional] |
|**corpusIds** | **List&lt;UUID&gt;** | IDs of the corpora the thread is bound to (UUIDv4). |  |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the thread. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the thread (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last modification of the thread (ISO-8601, UTC) — moved by &#x60;PATCH /v1/thread/{sessionId}&#x60;. Equal to &#x60;createdAt&#x60; on a thread nobody has patched. |  |
|**model** | **String** |  |  [optional] |



