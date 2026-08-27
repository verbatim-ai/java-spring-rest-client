

# KeyUpdateResponse

Acknowledgement returned after updating a key's name or description.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the key (UUIDv4). |  |
|**orgId** | **String** | ID of the owning organization (UUIDv4). |  |
|**name** | **String** | Name of the key. |  |
|**description** | **String** | Description of the key. |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | Lifecycle state. |  |
|**createdAt** | **OffsetDateTime** | Original creation timestamp (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Timestamp of this update (ISO-8601, UTC). |  |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| INACTIVE | &quot;INACTIVE&quot; |
| ACTIVE | &quot;ACTIVE&quot; |



