

# Agent

Setup driving a RAG query: how wide the retrieval goes, whether results are re-ranked, what system instruction the model receives, how much history is replayed, and which models answer.  Two kinds of agent are returned by the same endpoints. **Core** agents belong to the platform, are visible to every organization and carry `lock: true` — they cannot be created, updated or deleted. **Custom** agents carry your `orgId`, `lock: false`, and are yours to manage.  Nullable fields are *overrides*, not copies. `null` means \"use the platform default\", so a default that is retuned later moves every agent that never set one. `systemInstruction` is read-only and shows the instruction those resolved values actually produce. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the agent (UUIDv4). |  |
|**name** | **String** | Human-readable name of the agent. |  |
|**description** | **String** | Free-form description of what this agent is for. |  [optional] |
|**lock** | **Boolean** | Read-only. &#x60;true&#x60; for a core agent: shared across the platform and not writable. Attempting to update or delete one answers &#x60;400&#x60;. |  |
|**topK** | **Integer** | Chunks the vector search returns, before re-ranking narrows them down. |  |
|**rerank** | **Boolean** | Whether the retrieved chunks are re-ranked by an LLM before the answer is generated. Re-ranking also needs &#x60;rerankModel&#x60;; with none set the flag has nothing to run. |  |
|**rerankTopK** | **Integer** | Chunks kept after re-ranking. &#x60;null&#x60; uses the platform default. |  [optional] |
|**context** | **String** | First third of the system instruction — what the model is looking at. &#x60;null&#x60; uses the platform default. |  [optional] |
|**behaviour** | **String** | Second third of the system instruction — how the model should act. &#x60;null&#x60; uses the platform default. |  [optional] |
|**spirit** | **String** | Last third of the system instruction — the tone it should take. &#x60;null&#x60; uses the platform default. |  [optional] |
|**useHistory** | **Boolean** | When &#x60;false&#x60;, previous posts of the session are not replayed and do not widen the embedded query — every question is answered on its own. |  |
|**historySize** | **Integer** | Number of trailing posts replayed. &#x60;null&#x60; replays the whole session. |  [optional] |
|**thinkingMode** | [**ThinkingModeEnum**](#ThinkingModeEnum) | Reasoning budget the model is asked to spend before answering. |  |
|**temperature** | **Double** | Model temperature. &#x60;null&#x60; leaves the model default untouched. Temperature must match model range. |  [optional] |
|**rerankModel** | **String** | Model used for re-ranking, as advertised by &#x60;GET /v1/config/model&#x60;. |  [optional] |
|**baseModel** | **String** | Model used to generate the answer, as advertised by &#x60;GET /v1/config/model&#x60;. &#x60;null&#x60; keeps whatever model the session was created with. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp (ISO-8601, UTC). Equal to &#x60;createdAt&#x60; on creation. |  |
|**_default** | **Boolean** | Read-only. &#x60;true&#x60; on the single agent the platform falls back to when a query names none. At most one agent carries it. |  |



## Enum: ThinkingModeEnum

| Name | Value |
|---- | -----|
| LOW | &quot;LOW&quot; |
| HIGH | &quot;HIGH&quot; |



