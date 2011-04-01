package net.northfuse.sfop

import scala.xml.Elem

trait BasicReport extends FOPRenderer {

	val simplePageMasterName = "simple"

	def buildLayout = {
  		<layout-master-set>
    			<simple-page-master master-name="{simplePageMasterName}"
                  		page-height="29.7cm"
                  		page-width="21cm"
                  		margin-top="1cm"
                  		margin-bottom="2cm"
                  		margin-left="2.5cm"
                  		margin-right="2.5cm">
      				<fo:region-body margin-top="3cm"/>
      				<fo:region-before extent="3cm"/>
      				<fo:region-after extent="1.5cm"/>
    			</simple-page-master>
  		</layout-master-set>
	}

	final override def buildXML = {
		<root xmlns:fo={foNamespace} xmlns={foNamespace}>
			{buildLayout}
			{buildPageSequence}
		</root>
	}

	def buildPageSequence = {
  		<page-sequence master-reference="{simplePageMasterName}">
			{buildRegionBody}
  		</page-sequence>
	}

	def buildRegionBody : Elem
}
