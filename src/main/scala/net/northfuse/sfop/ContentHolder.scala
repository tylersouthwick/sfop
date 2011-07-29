package net.northfuse.sfop

import scala.xml.Elem

trait ContentHolder[T <: Function0[Elem]] {
	private val contents = new java.util.LinkedList[T]

/*
	final def content = new {
		def +=(t : T) {
			contents.add(t)
		}
	}
	*/

	import scala.collection.JavaConversions._

	final def renderContents = contents foreach{_.apply()}
}
