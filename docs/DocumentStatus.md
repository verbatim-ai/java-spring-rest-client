

# DocumentStatus

Lightweight view of a document's ingestion lifecycle. Cheaper than fetching the full document, and intended for polling loops between commit and the final READY/FAILED status.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** | ID of the document (UUIDv4). |  [optional] |
|**status** | [**StatusEnum**](#StatusEnum) | Current lifecycle status of the document. |  [optional] |
|**statusMsg** | **String** | Optional human-readable detail attached to the status — typically a failure reason when &#x60;status &#x3D;&#x3D; FAILED&#x60;. &#x60;null&#x60; otherwise. |  [optional] |
|**updatedAt** | **OffsetDateTime** | Wall-clock timestamp of the last status update (ISO-8601, UTC). |  [optional] |



## Enum: StatusEnum

| Name | Value |
|---- | -----|
| AWAITING_UPLOAD | &quot;AWAITING_UPLOAD&quot; |
| PENDING | &quot;PENDING&quot; |
| PROCESSING | &quot;PROCESSING&quot; |
| READY | &quot;READY&quot; |
| FAILED | &quot;FAILED&quot; |



