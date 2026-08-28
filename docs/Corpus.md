

# Corpus

Knowledge base inside an organization. Bound to an embedding model and a summary LLM.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the corpus (UUIDv4). |  |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp (ISO-8601, UTC). |  |
|**name** | **String** | Human-readable name of the corpus. |  |
|**description** | **String** | Free-form description of the corpus. |  |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the corpus. Stored as JSONB. |  [optional] |



