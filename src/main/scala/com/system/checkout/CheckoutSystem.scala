package com.system.checkout

object CheckoutSystem {

  private def getPrice(name: String): Double = name match {
    case "Apple" => 0.6
    case "Orange" => 0.25
    case _ => 0
  }

  def getCount(name: String, list: Seq[String]): Int = list.count(_.equals(name))

  def getTotalCost(list: Seq[String]): Double = list.map(getPrice).sum

  def checkCurrentOffer(name: String, countInList: Int): Double = name match {

    case "Apple" => countInList match {
      case n if n >= 2 =>
        0.5 * countInList * getPrice(name)
      case _ =>
        countInList * getPrice(name)
    }
    case "Orange" => countInList match {
      case n if n >= 3 =>
        0.66667 * countInList * getPrice(name)
      case _ =>
        countInList * getPrice(name)
    }
    case _ =>
      0
  }

  def getDiscountOffer(name: String, list: Seq[String]): Double = {
    val count: Int = getCount(name, list: Seq[String])
    if (count != 0)
      checkCurrentOffer(name, count) else 0
  }

  def getTotalCostAfterDiscount(list: Seq[String]): Double = {
    getDiscountOffer("Apple", list: Seq[String]) + getDiscountOffer("Orange", list: Seq[String])
  }

}
