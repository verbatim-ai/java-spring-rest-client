

# Key

RSA public key owned by an organization and used to verify JWT signatures.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | Unique identifier of the key (UUIDv4). Use this value as the &#x60;kid&#x60; JWT header when signing tokens. |  |
|**orgId** | **String** | ID of the owning organization (UUIDv4). |  |
|**name** | **String** | Human-readable name of the key. |  |
|**description** | **String** | Free-form description of the key, set at creation. |  [optional] |
|**format** | [**FormatEnum**](#FormatEnum) | Format of the key content. |  |
|**preview** | **String** | Preview of the key, only the 100 first characters of the real key content |  [optional] |
|**state** | [**StateEnum**](#StateEnum) | Lifecycle state. A key is &#x60;INACTIVE&#x60; at creation, becomes &#x60;ACTIVE&#x60; once published, and can be toggled back and forth via activate/deactivate. Only &#x60;ACTIVE&#x60; keys verify JWTs. |  |
|**createdAt** | **OffsetDateTime** | Creation timestamp (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last update timestamp (ISO-8601, UTC). |  |



## Enum: FormatEnum

| Name | Value |
|---- | -----|
| PEM | &quot;PEM&quot; |



## Enum: StateEnum

| Name | Value |
|---- | -----|
| INACTIVE | &quot;INACTIVE&quot; |
| ACTIVE | &quot;ACTIVE&quot; |



