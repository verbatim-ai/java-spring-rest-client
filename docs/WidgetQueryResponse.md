

# WidgetQueryResponse


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**timestamp** | **OffsetDateTime** | Timestamp when the answer was generated |  [optional] |
|**sessionId** | **UUID** | Id of the session the query belongs to |  [optional] |
|**query** | **String** | The user query that was submitted |  [optional] |
|**body** | **String** | The AI-generated answer, may include markdown and source citations |  [optional] |
|**attachment** | **Integer** | Number of source document chunks cited in the answer |  [optional] |



