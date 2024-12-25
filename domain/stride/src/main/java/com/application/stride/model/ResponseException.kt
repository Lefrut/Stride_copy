package com.application.stride.model




open class StrideException : RuntimeException {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}


data object RegisterExceptions {

    class EmailAlreadyException(
        cause: Throwable? = null,
    ) : StrideException(cause = cause)

    class PhoneAlreadyException(
        cause: Throwable? = null,
    ) : StrideException(cause = cause)

    class SimplePasswordException(
        cause: Throwable? = null,
    ) : StrideException(cause = cause)


}


data object LoginExceptions{

    class InputException(
        cause: Throwable? = null,
    ) : StrideException(cause = cause)


}


