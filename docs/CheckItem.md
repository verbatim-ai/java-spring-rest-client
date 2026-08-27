

# CheckItem

Outcome of one subsystem probe.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**name** | **String** | Subsystem probed. |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | &#x60;UP&#x60; when the subsystem answered the probe, &#x60;DOWN&#x60; otherwise. |  [optional] |
|**durationMs** | **Long** | Wall-clock duration of the probe, in milliseconds. |  [optional] |
|**error** | **String** | Failure reason. Absent when the probe succeeded. |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| UP | &quot;UP&quot; |
| DOWN | &quot;DOWN&quot; |



