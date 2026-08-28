

# SessionCreateResponse

Acknowledgement returned after opening a new session.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** | ID of the newly created session (UUIDv4). |  |
|**userId** | **String** | Identifier of the user who opened the session (echo of the JWT subject). |  [optional] |
|**corpusId** | **List&lt;UUID&gt;** | IDs of the corpora the session is bound to (UUIDv4). |  |
|**model** | **String** |  |  [optional] |
|**metadata** | **Map&lt;String, Object&gt;** | Arbitrary JSON metadata attached to the session. |  [optional] |
|**createdAt** | **OffsetDateTime** | Creation timestamp of the session (ISO-8601, UTC). |  |
|**updatedAt** | **OffsetDateTime** | Last modification of the session (ISO-8601, UTC). Equal to &#x60;createdAt&#x60; on a session that has just been created. |  |



