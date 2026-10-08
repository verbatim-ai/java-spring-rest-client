

# DocumentUrlRequest

Body of POST /v1/doc/url. Names a web page to print to PDF and ingest into a corpus.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**corpusId** | **UUID** | ID of the corpus the document will be ingested into. |  |
|**url** | **String** | Absolute &#x60;https&#x60; URL of an HTML page, at most 2048 characters. It may not carry credentials (&#x60;user:password@&#x60;) — send those in &#x60;headers&#x60;. Stored in the document&#39;s &#x60;metadata.url&#x60;. |  |
|**scale** | **Double** | Rendering scale of the page, from &#x60;0.1&#x60; to &#x60;2&#x60;. Below 1 fits more of the page on each PDF page. Defaults to &#x60;1&#x60;. |  [optional] |
|**headers** | **Map&lt;String, String&gt;** | HTTP headers sent when loading the page — typically &#x60;Authorization&#x60; or &#x60;Cookie&#x60; for a page behind a login. Sent only to the page&#39;s own origin (scheme, host and port of &#x60;url&#x60;), never to the third-party assets it loads; never stored. At most 20. |  [optional] |



