package test;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Timer;
import java.util.concurrent.Executor;

import com.mysql.jdbc.Buffer;
import com.mysql.jdbc.CachedResultSetMetaData;
import com.mysql.jdbc.ExceptionInterceptor;
import com.mysql.jdbc.Extension;
import com.mysql.jdbc.Field;
import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.MysqlIO;
import com.mysql.jdbc.ResultSetInternalMethods;
import com.mysql.jdbc.ServerPreparedStatement;
import com.mysql.jdbc.SingleByteCharsetConverter;
import com.mysql.jdbc.StatementImpl;
import com.mysql.jdbc.StatementInterceptorV2;
import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.profiler.ProfilerEventHandler;

public class MockJDBC implements  MySQLConnection{

	
	private MockStatement expected;

	MockJDBC(String sql) throws SQLException{
		this.expected = new MockStatement(this, "", sql);
	}
	public void setExpected(String sql) {
		try {
			this.expected = new MockStatement(this, "", sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void abort(Executor arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abortInternal() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeUser(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkClosed() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearHasTriedMaster() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0) throws SQLException {
	
		return this.expected;
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return this.expected;
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0, int[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0, String[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement clientPrepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getConnectionMutex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSessionMaxRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasSameProperties(com.mysql.jdbc.Connection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasTriedMaster() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initializeExtension(Extension arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isInGlobalTx() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMasterConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNoBackslashEscapesSet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSameResource(com.mysql.jdbc.Connection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServerLocal() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean parserKnowsUnicode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ping() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportQueryTime(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetServerState() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0, int[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0, String[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement serverPrepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFailedOver(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInGlobalTx(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPreferSlaveDuringFailover(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSchema(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionMaxRows(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatementComment(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsIsolationLevel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsQuotedIdentifiers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supportsTransactions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean versionMeetsMinimum(int arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return expected;
	}

	@Override
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return expected;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String exposeAsXml() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowLoadLocalInfile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowMasterDownConnections() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowMultiQueries() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowNanAndInf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowPublicKeyRetrieval() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowSlaveDownConnections() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowUrlInLocalInfile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAlwaysSendSetIsolation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getAuthenticationPlugins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAutoClosePStmtStreams() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAutoDeserialize() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAutoGenerateTestcaseScript() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAutoReconnectForPools() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAutoSlowLog() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBlobSendChunkSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getBlobsAreStrings() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCacheCallableStatements() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCacheCallableStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCacheDefaultTimezone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCachePrepStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCachePreparedStatements() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCacheResultSetMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCacheServerConfiguration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCallableStatementCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCallableStmtCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getCapitalizeTypeNames() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCharacterSetResults() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientCertificateKeyStorePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientCertificateKeyStoreType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientCertificateKeyStoreUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientInfoProvider() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClobCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getClobberStreamingResults() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCompensateOnDuplicateKeyUpdateCounts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getConnectTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getConnectionCollation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConnectionLifecycleInterceptors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getContinueBatchOnError() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getCreateDatabaseIfNotExist() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDefaultAuthenticationPlugin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDefaultFetchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getDetectCustomCollations() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDisabledAuthenticationPlugins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getDisconnectOnExpiredPasswords() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDontCheckOnDuplicateKeyUpdateInSQL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDontTrackOpenResources() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDumpMetadataOnColumnNotFound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDumpQueriesOnException() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDynamicCalendars() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getElideSetAutoCommits() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEmptyStringsConvertToZero() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEmulateLocators() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEmulateUnsupportedPstmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEnableEscapeProcessing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEnablePacketDebug() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getEnableQueryTimeouts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getEnabledSSLCipherSuites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEnabledTLSProtocols() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getExceptionInterceptors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getExplainSlowQueries() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getFailOverReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getFunctionsNeverReturnBlobs() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getGatherPerfMetrics() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getGatherPerformanceMetrics() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getGenerateSimpleParameterMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getGetProceduresReturnsFunctions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getHoldResultsOpenOverStatementClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIgnoreNonTxTables() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIncludeInnodbStatusInDeadlockExceptions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIncludeThreadDumpInDeadlockExceptions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIncludeThreadNamesAsStatementComment() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getInitialTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getInteractiveClient() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getIsInteractiveClient() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getJdbcCompliantTruncation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getJdbcCompliantTruncationForReads() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLargeRowSizeThreshold() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoadBalanceAutoCommitStatementRegex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadBalanceAutoCommitStatementThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLoadBalanceBlacklistTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLoadBalanceConnectionGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getLoadBalanceEnableJMX() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLoadBalanceExceptionChecker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoadBalanceHostRemovalGracePeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLoadBalancePingTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLoadBalanceSQLExceptionSubclassFailover() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoadBalanceSQLStateFailover() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoadBalanceStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getLoadBalanceValidateConnectionOnSwapServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLocalSocketAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLocatorFetchBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getLogSlowQueries() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getLogXaCommands() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLoggerClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getMaintainTimeStats() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getMaxAllowedPacket() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxQuerySizeToLog() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxReconnects() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxRows() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMetadataCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNetTimeoutForStreamingResults() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getNoAccessToProcedureBodies() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNoDatetimeStringSync() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNoTimezoneConversionForDateType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNoTimezoneConversionForTimeType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNullCatalogMeansCurrent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getNullNamePatternMatchesAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getOverrideSupportsIntegrityEnhancementFacility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPacketDebugBufferSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getPadCharsWithSpace() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getParanoid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getParseInfoCacheFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswordCharacterEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPedantic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPinGlobalTxToPhysicalConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPopulateInsertRowWithDefaultValues() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPrepStmtCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPrepStmtCacheSqlLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreparedStatementCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPreparedStatementCacheSqlLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getProcessEscapeCodesForPrepStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getProfileSQL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getProfileSql() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getProfilerEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertiesTransform() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getQueriesBeforeRetryMaster() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getQueryTimeoutKillsConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getReadFromMasterWhenNoSlaves() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getReadOnlyPropagatesToServer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getReconnectAtTxEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRelaxAutoCommit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getReplicationEnableJMX() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getReportMetricsIntervalMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRequireSSL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getResourceId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getResultSetSizeThreshold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRetainStatementAfterResultSetClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRetriesAllDown() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRewriteBatchedStatements() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRollbackOnPooledClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRoundRobinLoadBalance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRunningCTS13() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSecondsBeforeRetryMaster() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelfDestructOnPingMaxOperations() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSelfDestructOnPingSecondsLifetime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getSendFractionalSeconds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getServerAffinityOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerConfigCacheFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerRSAPublicKeyFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerTimezone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSessionVariables() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSlowQueryThresholdMillis() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSlowQueryThresholdNanos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSocketFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSocketFactoryClassName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSocketTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSocksProxyHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSocksProxyPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getStatementInterceptors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getStrictFloatingPoint() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getStrictUpdates() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTcpKeepAlive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTcpNoDelay() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTcpRcvBuf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTcpSndBuf() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTcpTrafficClass() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getTinyInt1isBit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTraceProtocol() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTransformedBitIsBoolean() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getTreatUtilDateAsTimestamp() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTrustCertificateKeyStorePassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrustCertificateKeyStoreType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTrustCertificateKeyStoreUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUltraDevHack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseAffectedRows() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseBlobToStoreUTF8OutsideBMP() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseColumnNamesInFindColumn() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseCompression() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUseConfigs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getUseCursorFetch() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseDirectRowUnpack() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseDynamicCharsetInfo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseFastDateParsing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseFastIntParsing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseGmtMillisForDatetimes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseHostsInPrivileges() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseInformationSchema() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseJDBCCompliantTimezoneShift() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseJvmCharsetConverters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseLegacyDatetimeCode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseLocalSessionState() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseLocalTransactionState() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseNanosForElapsedTime() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseOldAliasMetadataBehavior() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseOldUTF8Behavior() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseOnlyServerErrorMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseReadAheadInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseSSL() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseSSPSCompatibleTimezoneShift() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseServerPrepStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseServerPreparedStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseSqlStateCodes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseStreamLengthsInPrepStmts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseTimezone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseUltraDevWorkAround() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseUnbufferedInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseUnicode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUseUsageAdvisor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUtf8OutsideBmpExcludedColumnNamePattern() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUtf8OutsideBmpIncludedColumnNamePattern() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getVerifyServerCertificate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getYearIsDateType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getZeroDateTimeBehavior() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUseSSLExplicit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAllowLoadLocalInfile(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowMasterDownConnections(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowMultiQueries(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowNanAndInf(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowPublicKeyRetrieval(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowSlaveDownConnections(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAllowUrlInLocalInfile(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlwaysSendSetIsolation(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAuthenticationPlugins(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoClosePStmtStreams(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoDeserialize(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoGenerateTestcaseScript(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoReconnect(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoReconnectForConnectionPools(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoReconnectForPools(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoSlowLog(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlobSendChunkSize(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBlobsAreStrings(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCacheCallableStatements(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCacheCallableStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCacheDefaultTimezone(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCachePrepStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCachePreparedStatements(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCacheResultSetMetadata(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCacheServerConfiguration(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCallableStatementCacheSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCallableStmtCacheSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapitalizeDBMDTypes(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCapitalizeTypeNames(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterSetResults(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientCertificateKeyStorePassword(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientCertificateKeyStoreType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientCertificateKeyStoreUrl(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfoProvider(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClobCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClobberStreamingResults(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCompensateOnDuplicateKeyUpdateCounts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConnectTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConnectionCollation(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConnectionLifecycleInterceptors(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setContinueBatchOnError(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreateDatabaseIfNotExist(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultAuthenticationPlugin(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultFetchSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetectCustomCollations(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDetectServerPreparedStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisabledAuthenticationPlugins(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDisconnectOnExpiredPasswords(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDontCheckOnDuplicateKeyUpdateInSQL(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDontTrackOpenResources(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDumpMetadataOnColumnNotFound(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDumpQueriesOnException(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDynamicCalendars(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setElideSetAutoCommits(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmptyStringsConvertToZero(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmulateLocators(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEmulateUnsupportedPstmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnableEscapeProcessing(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnablePacketDebug(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnableQueryTimeouts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabledSSLCipherSuites(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabledTLSProtocols(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExceptionInterceptors(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExplainSlowQueries(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFailOverReadOnly(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFunctionsNeverReturnBlobs(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGatherPerfMetrics(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGatherPerformanceMetrics(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGenerateSimpleParameterMetadata(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setGetProceduresReturnsFunctions(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHoldResultsOpenOverStatementClose(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIgnoreNonTxTables(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeInnodbStatusInDeadlockExceptions(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeThreadDumpInDeadlockExceptions(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIncludeThreadNamesAsStatementComment(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInitialTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInteractiveClient(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setIsInteractiveClient(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJdbcCompliantTruncation(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJdbcCompliantTruncationForReads(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLargeRowSizeThreshold(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceAutoCommitStatementRegex(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceAutoCommitStatementThreshold(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceBlacklistTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceConnectionGroup(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceEnableJMX(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceExceptionChecker(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceHostRemovalGracePeriod(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalancePingTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceSQLExceptionSubclassFailover(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceSQLStateFailover(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceStrategy(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoadBalanceValidateConnectionOnSwapServer(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocalSocketAddress(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocatorFetchBufferSize(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogSlowQueries(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogXaCommands(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogger(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoggerClassName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaintainTimeStats(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxQuerySizeToLog(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxReconnects(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxRows(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadataCacheSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNetTimeoutForStreamingResults(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoAccessToProcedureBodies(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoDatetimeStringSync(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoTimezoneConversionForDateType(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNoTimezoneConversionForTimeType(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNullCatalogMeansCurrent(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNullNamePatternMatchesAll(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOverrideSupportsIntegrityEnhancementFacility(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPacketDebugBufferSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPadCharsWithSpace(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParanoid(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParseInfoCacheFactory(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPasswordCharacterEncoding(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPedantic(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPinGlobalTxToPhysicalConnection(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPopulateInsertRowWithDefaultValues(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrepStmtCacheSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPrepStmtCacheSqlLimit(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPreparedStatementCacheSize(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPreparedStatementCacheSqlLimit(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProcessEscapeCodesForPrepStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProfileSQL(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProfileSql(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProfilerEventHandler(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPropertiesTransform(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setQueriesBeforeRetryMaster(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setQueryTimeoutKillsConnection(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReadFromMasterWhenNoSlaves(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReadOnlyPropagatesToServer(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReconnectAtTxEnd(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRelaxAutoCommit(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReplicationEnableJMX(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReportMetricsIntervalMillis(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRequireSSL(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResourceId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setResultSetSizeThreshold(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRetainStatementAfterResultSetClose(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRetriesAllDown(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRewriteBatchedStatements(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRollbackOnPooledClose(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRoundRobinLoadBalance(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRunningCTS13(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSecondsBeforeRetryMaster(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelfDestructOnPingMaxOperations(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSelfDestructOnPingSecondsLifetime(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSendFractionalSeconds(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerAffinityOrder(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerConfigCacheFactory(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerRSAPublicKeyFile(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setServerTimezone(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSessionVariables(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlowQueryThresholdMillis(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSlowQueryThresholdNanos(long arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSocketFactory(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSocketFactoryClassName(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSocketTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSocksProxyHost(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSocksProxyPort(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStatementInterceptors(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStrictFloatingPoint(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setStrictUpdates(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTcpKeepAlive(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTcpNoDelay(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTcpRcvBuf(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTcpSndBuf(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTcpTrafficClass(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTinyInt1isBit(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTraceProtocol(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTransformedBitIsBoolean(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTreatUtilDateAsTimestamp(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrustCertificateKeyStorePassword(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrustCertificateKeyStoreType(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTrustCertificateKeyStoreUrl(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUltraDevHack(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseAffectedRows(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseBlobToStoreUTF8OutsideBMP(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseColumnNamesInFindColumn(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseCompression(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseConfigs(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseCursorFetch(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseDirectRowUnpack(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseDynamicCharsetInfo(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseFastDateParsing(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseFastIntParsing(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseGmtMillisForDatetimes(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseHostsInPrivileges(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseInformationSchema(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseJDBCCompliantTimezoneShift(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseJvmCharsetConverters(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseLegacyDatetimeCode(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseLocalSessionState(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseLocalTransactionState(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseNanosForElapsedTime(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseOldAliasMetadataBehavior(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseOldUTF8Behavior(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseOnlyServerErrorMessages(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseReadAheadInput(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseSSL(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseSSPSCompatibleTimezoneShift(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseServerPrepStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseServerPreparedStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseSqlStateCodes(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseStreamLengthsInPrepStmts(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseTimezone(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseUltraDevWorkAround(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseUnbufferedInput(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseUnicode(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUseUsageAdvisor(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUtf8OutsideBmpExcludedColumnNamePattern(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUtf8OutsideBmpIncludedColumnNamePattern(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVerifyServerCertificate(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setYearIsDateType(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setZeroDateTimeBehavior(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean useUnbufferedInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createNewIO(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decachePreparedStatement(ServerPreparedStatement arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dumpTestcaseQuery(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.mysql.jdbc.Connection duplicate() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetInternalMethods execSQL(StatementImpl arg0, String arg1, int arg2, Buffer arg3, int arg4, int arg5,
			boolean arg6, String arg7, Field[] arg8) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetInternalMethods execSQL(StatementImpl arg0, String arg1, int arg2, Buffer arg3, int arg4, int arg5,
			boolean arg6, String arg7, Field[] arg8, boolean arg9) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String extractSqlFromPacket(String arg0, Buffer arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder generateConnectionCommentBlock(StringBuilder arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MySQLConnection getActiveMySQLConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getActiveStatementCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAutoIncrementIncrement() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CachedResultSetMetaData getCachedMetaData(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar getCalendarInstanceForSessionOrNew() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Timer getCancelTimer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharacterSetMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SingleByteCharsetConverter getCharsetConverter(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharsetNameForIndex(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getConnectionAttributes() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeZone getDefaultTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEncodingForIndex(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessageEncoding() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExceptionInterceptor getExceptionInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHostPortPair() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MysqlIO getIO() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getIdleFor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MySQLConnection getLoadBalanceSafeProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log getLog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxBytesPerChar(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxBytesPerChar(Integer arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Statement getMetadataSafeStatement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MySQLConnection getMultiHostSafeProxy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNetBufferLength() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProfilerEventHandler getProfilerEventHandlerInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getRequiresEscapingEncoder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getServerCharset() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getServerMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getServerMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getServerSubMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TimeZone getServerTimezoneTZ() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerVariable(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar getSessionLockedCalendar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatementComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StatementInterceptorV2> getStatementInterceptorsInstances() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calendar getUtcCalendar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void incrementNumberOfPreparedExecutes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementNumberOfPrepares() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incrementNumberOfResultSetsCreated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeResultsMetadataFromCache(String arg0, CachedResultSetMetaData arg1,
			ResultSetInternalMethods arg2) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeSafeStatementInterceptors() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAbonormallyLongQuery(long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isClientTzUTC() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCursorFetchEnabled() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProxySet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadInfoMsgEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRunningOnJDK13() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServerTzUTC() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lowerCaseTableNames() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void pingInternal(boolean arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void realClose(boolean arg0, boolean arg1, boolean arg2, Throwable arg3) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recachePreparedStatement(ServerPreparedStatement arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerQueryExecutionTime(long arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerStatement(com.mysql.jdbc.Statement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reportNumberOfTablesAccessed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean serverSupportsConvertFn() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProfilerEventHandlerInstance(ProfilerEventHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProxy(MySQLConnection arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReadInfoMsgEnabled(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReadOnlyInternal(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdownServer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean storesLowerCaseTableName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void throwConnectionClosedException() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transactionBegun() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transactionCompleted() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unSafeStatementInterceptors() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterStatement(com.mysql.jdbc.Statement arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean useAnsiQuotedIdentifiers() {
		// TODO Auto-generated method stub
		return false;
	}
	
}