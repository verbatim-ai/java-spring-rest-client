

# AgentUpdateRequest

Patch a custom agent. Every field is optional; the ones you omit keep their current value.  Because an omitted field means \"leave alone\", it cannot also mean \"put this back to the platform default\". That is what `reset` is for: list the names of the nullable fields you want to un-set, and they go back to tracking the platform default instead of holding the value you gave them earlier. `reset` is applied after the rest of the body, so naming a field in both wins for `reset`.  Core agents (`lock: true`) are not writable — patching one answers `400`. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Human-readable name of the agent. Max 128 characters. Renaming onto a name another of your agents holds, or one a platform agent (&#x60;lock: true&#x60;) carries, answers &#x60;409&#x60;. Re-sending this agent&#39;s own current name is not a rename and is never a conflict. |  [optional] |
|**description** | **String** | Free-form description of what this agent is for. |  [optional] |
|**topK** | **Integer** | Chunks the vector search returns, before re-ranking narrows them down. |  [optional] |
|**rerank** | **Boolean** | Whether retrieved chunks are re-ranked by an LLM before the answer is generated. |  [optional] |
|**rerankTopK** | **Integer** | Chunks kept after re-ranking. |  [optional] |
|**context** | **String** | First third of the system instruction — what the model is looking at. |  [optional] |
|**behaviour** | **String** | Second third of the system instruction — how the model should act. |  [optional] |
|**spirit** | **String** | Last third of the system instruction — the tone it should take. |  [optional] |
|**useHistory** | **Boolean** | When &#x60;false&#x60;, previous posts of the session are not replayed. |  [optional] |
|**historySize** | **Integer** | Number of trailing posts replayed. |  [optional] |
|**thinkingMode** | [**ThinkingModeEnum**](#ThinkingModeEnum) | Reasoning budget the model spends before answering. |  [optional] |
|**temperature** | **Double** | Model temperature. Temperature must match model range. |  [optional] |
|**rerankModel** | **String** | Model used for re-ranking. Must be one of the names &#x60;GET /v1/config/model&#x60; advertises. |  [optional] |
|**baseModel** | **String** | Model used to generate the answer. Must be one of the names &#x60;GET /v1/config/model&#x60; advertises. |  [optional] |
|**reset** | **List&lt;String&gt;** | Fields to un-set, so they go back to tracking the platform default. Only the nullable fields can be reset; anything else answers &#x60;400&#x60;. Applied after the rest of the body. |  [optional] |



## Enum: ThinkingModeEnum

| Name | Value |
|---- | -----|
| LOW | &quot;LOW&quot; |
| HIGH | &quot;HIGH&quot; |



