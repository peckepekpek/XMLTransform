<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" omit-xml-declaration="yes"/>
  <xsl:template match="/">
          <xsl:for-each select="server/profile/subsystem/datasources/datasource">
            <xsl:variable name="tira" select="connection-url" />
            <xsl:variable name="hastaHost" select="substring-before($tira, ')(PORT=')"/>
            <xsl:variable name="hastaPort" select="substring-before($tira, ')))(CONNECT')"/>
            <xsl:variable name="serviceNameUtil" select="substring-after($tira, 'SERVICE_NAME=')"/>
            <xsl:variable name="nombreJNDI" select="@jndi-name"/>
            <xsl:variable name="nombreJNDIsinjava" select="substring-after($nombreJNDI, 'java:')"/>
            <xsl:variable name="numeroJuzgado" select="substring-after($nombreJNDI, 'jboss/env/jdbc/')"/>
/home_sistemas/ASA/jboss/jb6/creads 9203 encryptedSecurityDomain<xsl:value-of select="$numeroJuzgado"/><xsl:text> </xsl:text><xsl:value-of select="security/user-name"/><xsl:text> </xsl:text><xsl:value-of select="security/password"/><xsl:text> </xsl:text>jboss\/env\/jdbc\/<xsl:value-of select="$numeroJuzgado"/><xsl:text> </xsl:text><xsl:value-of select="substring-after($hastaHost, 'HOST=')"/><xsl:text> </xsl:text><xsl:value-of select="substring-after($hastaPort, 'PORT=')"/><xsl:text> </xsl:text><xsl:value-of select="substring-before($serviceNameUtil, '))')"/> 20 OSID SC N
          </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>