

# SessionUpdateRequest

Payload to patch a session. Only the fields you set are updated; omit a field to leave it unchanged.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**model** | **String** | New LLM for the session. Must be installed on the Ollama runtime. Omit to keep the current model. |  [optional] |
|**system** | **String** | New system prompt. Omit to keep the current prompt. |  [optional] |
|**temperature** | **Double** | New sampling temperature. Omit to keep the current value. |  [optional] |
|**thinking** | **Boolean** | Enable or disable thinking mode. Omit to keep the current value. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | New JSON metadata. When provided, **replaces** the existing metadata map; omit to keep it unchanged. |  [optional] |



