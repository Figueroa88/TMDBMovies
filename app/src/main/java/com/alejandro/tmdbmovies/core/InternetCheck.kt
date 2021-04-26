package com.alejandro.tmdbmovies.core

import kotlinx.coroutines.coroutineScope
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

object InternetCheck
{
    suspend fun isNetworkAvailable() = coroutineScope {
        return@coroutineScope try
        {
            //Es como hacer un ping

            val sock = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)
            sock.connect(socketAddress, 2000)
            sock.close()
            true
        }
        catch (e: IOException)
        {
            false
        }
        catch (e: Exception)
        {
            false
        }
    }
}