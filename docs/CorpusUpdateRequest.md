

# CorpusUpdateRequest

Payload to patch a corpus. Only the fields you set are updated; omit a field to leave it unchanged. Everything patchable here is descriptive — nothing on a corpus affects how its documents were ingested or how queries against it are answered, so no edit re-processes anything.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | New name of the corpus. Omit to keep the current name. |  [optional] |
|**description** | **String** | New description of the corpus. Omit to keep the current description. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | New JSON metadata. When provided, **replaces** the existing metadata map; omit to keep it unchanged. |  [optional] |



