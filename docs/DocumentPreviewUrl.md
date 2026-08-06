

# DocumentPreviewUrl

Presigned URL granting direct client GET access to a single rendered preview image of one page of a document, at one rendering size.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**page** | **Integer** | Zero-based page index this preview represents. |  [optional] |
|**size** | [**SizeEnum**](#SizeEnum) | Rendering size of the preview image. |  |
|**url** | **String** | Presigned URL to GET the preview image. Single-use, time-limited. |  |
|**expiresAt** | **OffsetDateTime** | Wall-clock expiration of &#x60;url&#x60; (ISO-8601, UTC). After this, a fresh request is required. |  |



## Enum: SizeEnum

| Name | Value |
|---- | -----|
| SMALL | &quot;SMALL&quot; |
| MEDIUM | &quot;MEDIUM&quot; |



