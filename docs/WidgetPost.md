

# WidgetPost


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | Unique identifier of the post |  [optional] |
|**text** | **String** | Message text; AI answers may contain markdown and a Sources section |  [optional] |
|**owner** | [**OwnerEnum**](#OwnerEnum) | Who sent this message: USER for end-user queries, SYSTEM for AI-generated answers |  [optional] |
|**lang** | **String** | ISO language code used when generating the answer |  [optional] |
|**sentAt** | **OffsetDateTime** | Timestamp when the message was created |  [optional] |
|**attachment** | **Integer** | Number of source document chunks cited in this answer (0 for user messages) |  [optional] |



## Enum: OwnerEnum

| Name | Value |
|---- | -----|
| USER | &quot;USER&quot; |
| SYSTEM | &quot;SYSTEM&quot; |



