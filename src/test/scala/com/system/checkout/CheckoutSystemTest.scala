package com.system.checkout

import org.scalatest.{FunSuite, Matchers}

class CheckoutSystemTest extends FunSuite with Matchers {


  test("An empty List should have total Cost 0") {
    val input = List.empty
    CheckoutSystem.getTotalCost(input) should be(0)
  }

  test("Cost of Each Apple is 0.6 ") {
    val input = List("Apple")
    CheckoutSystem.getTotalCost(input) should be(0.6)
  }

  test("Cost of Each Orange is 0.25") {
    val input = List("Orange")
    CheckoutSystem.getTotalCost(input) should be(0.25)
  }

  test("Calculation of total cost ") {
    val input = List("Orange", "Apple", "Orange", "Apple", "Apple")
    CheckoutSystem.getTotalCost(input) should be(2.3000000000000003)
  }

  test("get exact count from list") {
    val input = List("Orange", "Apple", "Orange", "Apple", "Orange")
    CheckoutSystem.getCount("Orange", input) should be(3)
    CheckoutSystem.getCount("Apple", input) should be(2)
  }

  test("check for any existing offers") {
    CheckoutSystem.checkCurrentOffer("Apple", 4) should be(1.2)
    CheckoutSystem.checkCurrentOffer("Orange", 3) should be(0.5000025)
  }

  test("get discount for apples ") {
    val input = List("Apple", "Apple", "Apple", "Apple")
    CheckoutSystem.getTotalCostAfterDiscount(input) should be(1.2)
  }

  test("get discount for oranges ") {
    val input = List("Orange", "Orange", "Orange")
    CheckoutSystem.getTotalCostAfterDiscount(input) should be(0.5000025)

  }

  test("get exact discount for apples,oranges ") {
    val input = List("Apple", "Apple", "Orange", "Orange", "Orange")
    CheckoutSystem.getTotalCostAfterDiscount(input) should be(1.1000025)
  }

  test("get No discount when discount is not valid ") {
    val input = List("Apple", "Orange", "Orange")
    CheckoutSystem.getTotalCostAfterDiscount(input) should be(1.1)
  }

}
