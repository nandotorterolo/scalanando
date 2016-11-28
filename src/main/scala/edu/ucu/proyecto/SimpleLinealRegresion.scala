package edu.ucu.proyecto

import breeze.linalg._
import DenseMatrix._
import scala.annotation.tailrec

/**
  * http://oliverdaff.github.io/scala/breeze/%E2%80%98machine/learning%E2%80%99/2015/02/01/Simple-Linear-Regression-Brezze.html
  */
class SimpleLinealRegresion {

  type History = DenseMatrix[Double]
  type Theta = DenseMatrix[Double]

  /**
    * Mean squared error function: http://en.wikipedia.org/wiki/Mean_squared_error
    * @param X
    * @param y
    * @param theta
    * @return
    */
  def computeCost(X: DenseMatrix[Double], y: DenseMatrix[Double], theta: Theta): Double = {
    val m = y.rows
    sum((X * theta - y) :^ 2d) / (2 * m)
  }

  /**
    * Linear regression attempts to find the value of theta that produces the smallest result of the cost function.
    * The algorithm does this using gradient descent.
    * For simple regression the problem can be though of as fitting a straight line to a graph, which fits the equation:
    * y = c + mx
    * The linear descent algorithm can be implemented in octave as shown below:
    */
  def gradientDescent(X: DenseMatrix[Double], y: DenseMatrix[Double], theta: Theta, alpha: Double, numberItr: Int): (Theta, History) = {
    val m = y.rows

    @tailrec
    def descend(newTheta: DenseMatrix[Double], history: DenseMatrix[Double], decentRemaining: Int):(DenseMatrix[Double], DenseMatrix[Double])  = {
      decentRemaining match {
        case 0 => (newTheta, history)
        case _ =>
          val htheta = X * newTheta
          val theta0 = newTheta(0,0) - alpha / m * sum((htheta - y) :* X(::, 0).t)
          val theta1 = newTheta(1,0) - alpha / m * sum((htheta - y) :* X(::, 1).t)
          val cost = computeCost(X, y, DenseMatrix(theta0, theta1))
          descend(DenseMatrix(theta0, theta1),
            horzcat(DenseMatrix(cost), history), decentRemaining - 1)
      }
    }

    descend(theta, DenseMatrix(computeCost(X, y, theta)), numberItr)
  }

  val monkeyFile = new java.io.File("monkeys.csv")
  val fileData = csvread(monkeyFile)

  val X_vector = fileData(::, 0) //isolate the first row
  val X = X_vector.asDenseMatrix.t //transpose from horizontal to vertical

  val y_vector = fileData(::, 1) //isolate the results
  val y = y_vector.asDenseMatrix.t

  val X1 = horzcat(ones[Double](X.rows, 1), X) //add on the theta zero col

  val theta = zeros[Double](X1.cols, 1) //create an initial theta value
  val iterations = 1500
  val alpha = 0.01

  val result = gradientDescent(X1, y, theta, alpha, iterations)

}
