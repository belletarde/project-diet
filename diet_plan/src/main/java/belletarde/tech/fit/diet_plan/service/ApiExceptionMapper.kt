package belletarde.tech.fit.diet_plan.service


import belletarde.tech.fit.diet_plan.service.exception.NoInternetException
import belletarde.tech.fit.diet_plan.service.exception.TimeOutException
import belletarde.tech.fit.diet_plan.service.exception.UnauthorizedException
import belletarde.tech.fit.diet_plan.service.exception.UnexpectedException
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

object ApiExceptionMapper {

    fun map(throwable: Throwable): Throwable {
        if (throwable is HttpException) {
            val response = throwable.response()
            return when (response.code()) {
                HttpURLConnection.HTTP_UNAUTHORIZED -> UnauthorizedException()
                else -> UnexpectedException()
            }
        }

        // A timeout happened
        if (throwable is SocketTimeoutException) return TimeOutException()

        // A network error happened
        return if (throwable is IOException) NoInternetException() else throwable
    }
}