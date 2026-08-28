

# Post

Single user query or system answer inside a session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the post (UUIDv4). |  |
|**sessionId** | **UUID** | ID of the session this post belongs to. |  |
|**agentId** | **UUID** | Agent this answer was produced under |  |
|**body** | **String** | Text content of the post — the user query when &#x60;owner &#x3D; USER&#x60;, the LLM answer when &#x60;owner &#x3D; SYSTEM&#x60;. |  |
|**owner** | [**OwnerEnum**](#OwnerEnum) | Who produced the post. |  |
|**token** | **Integer** | Token count of &#x60;body&#x60;, as measured by the model. |  [optional] |
|**lang** | **String** | ISO-639 language code used for the post. |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the post. Stored as JSONB. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the post (ISO-8601, UTC). |  |
|**attachment** | **Integer** | Number of attachment used in the post. Used /post/attachment to get details. Filled only when post have more than one attachment. Zero when no attachment. |  [optional] |



## Enum: OwnerEnum

| Name | Value |
|---- | -----|
| USER | &quot;USER&quot; |
| SYSTEM | &quot;SYSTEM&quot; |



