

# CorpusUpdateRequest

Payload to patch a corpus. Only the fields you set are updated; omit a field to leave it unchanged. Changing the embedding or summary model does **not** re-process already-ingested documents.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | New name of the corpus. Omit to keep the current name. |  [optional] |
|**description** | **String** | New description of the corpus. Omit to keep the current description. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | New JSON metadata. When provided, **replaces** the existing metadata map; omit to keep it unchanged. |  [optional] |



