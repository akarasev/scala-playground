package example

/**
  * <h3>Stacks: balanced brackets</h3>
  * <p>
  *   A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
  * </p>
  * <p>
  *   Two brackets are considered to be a matched pair if the an opening bracket
  *   (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or })
  *   of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
  * </p>
  * <p>
  *   A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
  *   For example, {[(])} is not balanced because the contents in between { and } are not balanced.
  *   The pair of square brackets encloses a single, unbalanced opening bracket, (,
  *   and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
  * </p>
  * <p>
  *   By this logic, we say a sequence of brackets is considered to be balanced
  *   if the following conditions are met:
  * </p>
  * <ul>
  *   <li>It contains no unmatched brackets.</li>
  *   <li>
  *     The subset of brackets enclosed within the confines of
  *     a matched pair of brackets is also a matched pair of brackets.
  *   </li>
  * </ul>
  * <p>
  */
object BracketBalancer {

  /**
    * Given strings of brackets, determine whether each sequence of brackets is balanced.
    *
    * @param text text with brackets.
    * @return if a string is balanced, return true; otherwise, return false.
    */
  def isBalanced(text: String): Boolean = {
    var stack: List[Char] = List()

    text.foreach {
      case '{' => stack = '{' :: stack
      case '}' => if ('{' == stack.head) stack = stack.tail
      case '[' => stack = '[' :: stack
      case ']' => if ('[' == stack.head) stack = stack.tail
      case '(' => stack = '(' :: stack
      case ')' => if ('(' == stack.head) stack = stack.tail
    }

    stack.isEmpty
  }

  /**
    * Alternative parentheses balance check (with recursion).
    *
    * @param text text with brackets.
    * @return if a string is balanced, return true; otherwise, return false.
    */
  def isBalancedRecursion(text: String): Boolean = {

    def isBalanced(text: List[Char], numOpens: Int): Boolean = {
      if (text.isEmpty) {
        numOpens == 0
      } else {
        val n: Int =
          if ('(' == text.head) numOpens + 1
          else if (')' == text.head) numOpens - 1
          else numOpens

        isBalanced(text.tail, n)
      }
    }

    isBalanced(text.toList, 0)
  }

}
