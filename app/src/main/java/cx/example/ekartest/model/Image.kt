package cx.example.ekartest.model

// This data class represents Image of a vehicle
data class Image(
    val mime: String,
    val link: String,
    val contextLink: String,
    val height: Int,
    val width: Int,
    val byteSize: Int,
    val thumbnailLink: String,
    val thumbnailHeight: Int,
    val thumbnailWidth: Int,
    val hostPageDomainFriendlyName: String,
    val accentColor: String,
    val datePublished: String
)
