

# DocumentConvertResponse

A document converted to Markdown by `POST /v1/doc/convert`. Nothing is stored: this payload is the whole result. 

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**contentType** | **String** | Format the document was recognised as, detected from its content (and the extension of &#x60;filename&#x60;, when sent). |  |
|**filename** | **String** | The &#x60;filename&#x60; sent, echoed back. Absent when none was sent. |  [optional] |
|**size** | **Long** | Size of the converted document, in bytes. |  |
|**pages** | **Integer** | Number of pages, for formats that have pages (PDF, Word, PowerPoint, …). Absent otherwise. |  [optional] |
|**markdown** | **String** | The document as Markdown. Tables are pipe tables, a spreadsheet gives one section per sheet. Images are not described — a scanned PDF yields no text. |  |
|**warnings** | **List&lt;String&gt;** | Problems the converter recovered from — an embedded file it could not read, a damaged part it skipped — and a note when no text could be extracted at all. Empty when the conversion was clean. |  [optional] |



