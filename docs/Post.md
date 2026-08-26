

# Post

Single user query or system answer inside a session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier of the post (UUIDv4). |  |
|**sessionId** | **String** | ID of the session this post belongs to. |  |
|**body** | **String** | Text content of the post — the user query when &#x60;owner &#x3D; USER&#x60;, the LLM answer when &#x60;owner &#x3D; SYSTEM&#x60;. |  |
|**owner** | [**OwnerEnum**](#OwnerEnum) | Who produced the post. |  |
|**token** | **Integer** | Token count of &#x60;body&#x60;, as measured by the model. |  [optional] |
|**lang** | **String** | ISO-639 language code used for the post. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the post. Stored as JSONB. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the post (ISO-8601, UTC). |  |
|**attachments** | [**List&lt;Attachment&gt;**](Attachment.md) | DEPRECATED. Use /post/attachment to get accurate list. Legacy info :Document chunks used as context for this post. Only populated on system answers. |  [optional] |
|**attachment** | **Integer** | Number of attachment used in the post. Used /post/attachment to get details. Filled only when post have more than one attachment. Zero when no attachment. |  [optional] |
|**agentId** | **String** | Agent this answer was produced under, when the query named one explicitly (&#x60;GET /v1/post/q?agentId&#x3D;…&#x60;). Absent when the query ran on the platform default agent, which is the usual case — so a missing &#x60;agentId&#x60; means \&quot;default\&quot;, not \&quot;unknown\&quot;. Only system answers carry it; the user&#39;s question never does. Deleting an agent does not rewrite the answers it produced, so this still identifies an agent you have since deleted — resolving it through &#x60;GET /v1/agent/{agentId}&#x60; then answers &#x60;404&#x60;. |  [optional] |



## Enum: OwnerEnum

| Name | Value |
|---- | -----|
| USER | &quot;USER&quot; |
| SYSTEM | &quot;SYSTEM&quot; |



