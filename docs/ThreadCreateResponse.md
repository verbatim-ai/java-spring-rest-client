

# ThreadCreateResponse

Acknowledgement returned after opening a new thread.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | ID of the newly created thread (UUIDv4). |  |
|**userId** | **String** | Identifier of the user who opened the thread (echo of the JWT subject). |  [optional] |
|**corpusId** | **List&lt;UUID&gt;** | IDs of the corpora the thread is bound to (UUIDv4). |  |
|**model** | **String** |  |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the thread. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the thread (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last modification of the thread (ISO-8601, UTC). Equal to &#x60;createdAt&#x60; on a thread that has just been created. |  |



