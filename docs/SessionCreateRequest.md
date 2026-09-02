

# SessionCreateRequest

Payload to open a new conversation session. A session needs only the corpora it searches: how its queries are answered is decided per query by the agent they name, not here. The owner is taken from your token.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusIds** | **List&lt;UUID&gt;** | IDs of the corpora the session is bound to (UUIDv4). A session may search across several corpora. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the session. Stored as JSONB. |  [optional] |



