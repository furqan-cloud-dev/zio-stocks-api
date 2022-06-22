package com.stocks.stocksapi

import zio.test._
import zio.test.Assertion._
import zhttp.http._

object StocksapiSpec extends DefaultRunnableSpec {
  override def spec: ZSpec[Environment, Failure] = suite("""StocksapiSpec""")(
    testM("200 ok") {
      checkAllM(Gen.fromIterable(List("text", "json"))) { uri =>
        val request = Request(Method.GET, URL(!! / uri))
        assertM(Stocksapi.app(request).map(_.status))(equalTo(Status.OK))
      }
    },
  )
}
