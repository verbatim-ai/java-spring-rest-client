

# KeyCreateResponse

Acknowledgement returned after registering a new key slot. The key starts in `INACTIVE` state with no content.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the newly created key (UUIDv4). Use this value as the &#x60;kid&#x60; JWT header when signing tokens. |  |
|**orgId** | **String** | ID of the owning organization (UUIDv4). |  |
|**name** | **String** | Name of the key. |  |
|**description** | **String** | Description of the key. |  [optional] |
|**format** | **String** | Format of the key content. |  |
|**state** | [**StateEnum**](#StateEnum) | Initial lifecycle state — always &#x60;INACTIVE&#x60; right after creation. |  |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| INACTIVE | &quot;INACTIVE&quot; |
| ACTIVE | &quot;ACTIVE&quot; |



