package org.northfuse.sfop

import org.apache.fop.apps._
import javax.xml.transform.stream.StreamSource
import javax.xml.transform._
import javax.xml.transform.sax._
import scala.xml.Elem
import java.io._
import org.apache.fop.apps.MimeConstants
import MimeConstants._

trait FOP {
	def buildXML: Elem

	val foNamespace = "http://www.w3.org/1999/XSL/Format"

        //TODO find a more efficient way to convert an Elem to a Source
	implicit def toStreamSource(x: Elem): Source = new StreamSource(new StringReader(x.toString))

	def generateReport(os: OutputStream) = {
		val fop = fopFactory.newFop(MIME_PDF, os)
		val transformer = transferFactory.newTransformer
		val result = new SAXResult(fop.getDefaultHandler())
		transformer.transform(buildXML, result)
		os.close
	}

	val fopFactory = FopFactory.newInstance
	val transferFactory = TransformerFactory.newInstance
}

