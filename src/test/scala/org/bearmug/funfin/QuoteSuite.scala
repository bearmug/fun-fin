package org.bearmug.funfin

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class QuoteSuite extends FunSuite {
  test("quote return 1") {
    def quote = new Quote()
    assert(quote.generate == 1)
  }
}
