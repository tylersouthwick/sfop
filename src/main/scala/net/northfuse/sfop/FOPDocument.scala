package net.northfuse.sfop

import org.apache.fop.apps._
import javax.xml.transform.stream.StreamSource
import javax.xml.transform._
import javax.xml.transform.sax._
import scala.xml.Elem
import java.io._
import org.apache.fop.apps.MimeConstants
import MimeConstants._

object FOPDocument {
	val foNamespace = "http://www.w3.org/1999/XSL/Format"
	val LOG = org.apache.log4j.Logger.getLogger(classOf[FOPDocument])
}

import scala.xml.Node
import scala.collection.JavaConversions._

trait FOPDocument extends FOPRenderer {
	import FOPDocument._

	final protected def buildXML = <root xmlns:fo={foNamespace} xmlns={foNamespace}>
		<layout-master-set>{layoutMasterSet}</layout-master-set>
		{pageSequence}
	</root>

/*
	private val contents = new java.util.LinkedList[Content]
	*/

	def layoutMasterSet : Seq[Node]
	def pageSequence : Seq[Node]

/*
	val content = new {
		def +=(content : Content) {
			contents.add(content)
		}
	}
	*/
}

