

# UsageDelta

Per-bucket create/remove deltas. For `storage`, the values are bytes rather than item counts.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**created** | **Long** | Items whose &#x60;created_at&#x60; falls inside this bucket. |  |
|**removed** | **Long** | Items whose &#x60;deleted_at&#x60; falls inside this bucket (soft-deletes only — a hard delete leaves no trace). |  |



