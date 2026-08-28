

# WhoAmI

Identity of the authenticated caller, as resolved from the Bearer token.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**organizationId** | **UUID** | ID of the organization the caller belongs to (UUIDv4). |  [optional] |
|**userId** | **String** | Unique identifier of the authenticated user (UUIDv4). |  [optional] |
|**email** | **String** | Email address of the authenticated user. |  [optional] |
|**name** | **String** | Display name of the authenticated user. |  [optional] |
|**timestamp** | **OffsetDateTime** | Reference timestamp the metadata were computed at (ISO-8601, UTC). |  [optional] |



