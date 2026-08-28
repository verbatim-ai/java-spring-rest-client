

# CorpusCreateResponse

Acknowledgement returned after creating a corpus.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | ID of the newly created corpus (UUIDv4). |  |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  |
|**name** | **String** | Name of the corpus. |  |
|**description** | **String** | Description of the corpus. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | JSON metadata attached to the corpus. |  [optional] |
|**orgId** | **String** |  |  [optional] |



