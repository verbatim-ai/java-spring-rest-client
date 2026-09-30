

# Model

One LLM the platform is configured to serve, with what a client needs to present it.  `id` is the contract: it is the value an agent's `baseModel` or `rerankModel` is set to, and the only field the server reads back. The other three exist to be rendered — a picker built from this endpoint shows `name`, `description` and `iconUrl` and sends `id`.  `name` and `description` are editorial and may be reworded at any time; do not match on them. Which concrete provider model an `id` runs on is deliberately absent — it changes under you without the `id` changing, which is the point of naming the alias. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Identifier of the model — the value to send anywhere a model is named. |  |
|**name** | **String** | Display name, for a model picker or the header of an answer. |  [optional] |
|**description** | **String** | One-line description of what the model is good for, for a tooltip or a line under the name. |  [optional] |
|**iconUrl** | **String** | Absolute URL of the model&#39;s icon — the provider&#39;s own logo, an SVG. Hosted off-platform, so render it as a remote image and keep a fallback for the request failing. |  [optional] |



