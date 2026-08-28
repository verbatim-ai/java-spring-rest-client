

# PostItemResponse

Pair of posts produced by a query: the user message and the corresponding system answer.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**sessionId** | **UUID** | ID of the session the posts belong to (UUIDv4). |  |
|**query** | [**Post**](Post.md) | User post (the query). &#x60;owner &#x3D; USER&#x60;. |  [optional] |
|**answer** | [**Post**](Post.md) | System post (the LLM answer). &#x60;owner &#x3D; SYSTEM&#x60;, with attachments pointing to the chunks used as context. |  [optional] |



