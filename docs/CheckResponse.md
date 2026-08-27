

# CheckResponse

Aggregated health of the platform subsystems.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**status** | [**StatusEnum**](#StatusEnum) | &#x60;UP&#x60; when every probe succeeded, &#x60;DOWN&#x60; as soon as one failed. Mirrors the HTTP status: &#x60;UP&#x60; is returned with 200, &#x60;DOWN&#x60; with 500. |  [optional] |
|**message** | **String** | Reason of the failure, prefixed by the subsystem it comes from. Absent when every probe succeeded. |  [optional] |
|**checks** | [**List&lt;CheckItem&gt;**](CheckItem.md) | One entry per subsystem, whatever the outcome. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| UP | &quot;UP&quot; |
| DOWN | &quot;DOWN&quot; |



