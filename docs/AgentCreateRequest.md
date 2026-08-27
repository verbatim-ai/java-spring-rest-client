

# AgentCreateRequest

Payload to create a custom agent inside your organization.  Only `name` is required. Every other field falls back to a documented default, so the smallest useful body is `{\"name\": \"...\"}` — and each field left out stays tied to the platform default rather than being frozen at today's value.  The created agent is always a custom one: it is attached to the organization carried by your credentials, `lock` is `false` and `default` is `false`. Core agents are seeded by the platform and cannot be created over the API. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Human-readable name of the agent. Max 128 characters, and unique in the listing you see — a name one of your own agents uses, or one a platform agent (&#x60;lock: true&#x60;) carries, answers &#x60;409&#x60;. Compared exactly, so &#x60;Support&#x60; and &#x60;support&#x60; are two names and &#x60;Verbatim Default v2&#x60; is free. |  |
|**description** | **String** | Free-form description of what this agent is for. |  [optional] |
|**topK** | **Integer** | Chunks the vector search returns, before re-ranking narrows them down. Defaults to &#x60;5&#x60;. |  [optional] |
|**rerank** | **Boolean** | Whether retrieved chunks are re-ranked by an LLM before the answer is generated. Defaults to &#x60;true&#x60;. |  [optional] |
|**rerankTopK** | **Integer** | Chunks kept after re-ranking. Omit to track the platform default. |  [optional] |
|**context** | **String** | First third of the system instruction — what the model is looking at. Omit to track the platform default. |  [optional] |
|**behaviour** | **String** | Second third of the system instruction — how the model should act. Omit to track the platform default. |  [optional] |
|**spirit** | **String** | Last third of the system instruction — the tone it should take. Omit to track the platform default. |  [optional] |
|**useHistory** | **Boolean** | When &#x60;false&#x60;, previous posts of the session are not replayed. Defaults to &#x60;true&#x60;. |  [optional] |
|**historySize** | **Integer** | Number of trailing posts replayed. Omit to replay the whole session. |  [optional] |
|**thinkingMode** | [**ThinkingModeEnum**](#ThinkingModeEnum) | Reasoning budget the model spends before answering. Defaults to &#x60;HIGH&#x60;. |  [optional] |
|**temperature** | **Double** | Sampling temperature, between 0 and 1. Omit to leave the model default untouched. |  [optional] |
|**rerankModel** | **String** | Model used for re-ranking. Must be one of the names &#x60;GET /v1/config/model&#x60; advertises. |  [optional] |
|**baseModel** | **String** | Model used to generate the answer. Must be one of the names &#x60;GET /v1/config/model&#x60; advertises. Omit to keep whatever model the session was created with. |  [optional] |



## Enum: ThinkingModeEnum

| Name | Value |
|---- | -----|
| LOW | &quot;LOW&quot; |
| HIGH | &quot;HIGH&quot; |



