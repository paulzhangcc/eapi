<template>
	<div class="mybatis">
		<!--<mybatis-fragment v-if="currView=='see'" @close="currView='index'" :column="column" :table="table" style="min-height: 400px"/>-->
		<Row>
			<i-col span="24">
				<Button @click="init" type="primary" icon="md-refresh" style="float: right;">刷新</Button>
			</i-col>
		</Row>

		<Row class="table-list">
			<Table :loading="loading" border :columns="tableColumns" :data="tables" ref="table"></Table>
		</Row>

		<mybatis-gen v-model="modalVisible" :table="table" :columns="columns" @on-cancel="modalVisible=false" @on-ok="modalVisible = false"></mybatis-gen>
	</div>
</template>

<script>
	import {generatorDatabaseAll} from "../../../utils/interface";
	import {setStore, getStore} from "../../../utils/storage";
	import * as consts from '../../../utils/const';
	import mybatisGen from '../../../components/generator/mybatisGen.vue';
//	import mybatisFragment from "./mybatisFragment.vue";

	export default {
		name: "codeGeneratorMbatis",
		components: {mybatisGen},
		data() {
			return {
				tables: [], // 表单数据
				columnMaps: {},
				table: {},
				columns: [],
				modalVisible: false,
				loading: true, // 表单加载状态
				tableColumns: [
					{
						type: "index",
						width: 60,
						align: "center"
					},
					{
						title: "表名",
						key: "tableName"
					},
					{
						title: "描述",
						key: "remarks"
					},
					{
						title: "操作",
						key: "action",
						align: "center",
						render: (h, params) => {
							return h("div", [
								h(
									"Button",
									{
										props: {
											type: "primary",
											size: "small",
											icon: "ios-create-outline"
										},
										style: {
											marginRight: "5px"
										},
										on: {
											click: () => {
												this.see(params.row);
											}
										}
									},
									"查看"
								),
								h(
									"Button",
									{
										props: {
											type: "primary",
											size: "small",
											icon: "ios-create-outline"
										},
										style: {
											marginRight: "5px"
										},
										on: {
											click: () => {
												this.gen(params.row);
											}
										}
									},
									"生成"
								),

							]);
						}
					}
				],
				data: {} // 数据
			};
		},
		methods: {
			init() {
				this.getDataList();
			},
			getDataList() {
				this.loading = true;
				const db = getStore(consts.GENERATOR_CONFIG);
				if (!db) {
					this.$Message.error("请先配置数据库");
					this.loading = false;
					return;
				}
				generatorDatabaseAll(JSON.parse(db), (data) => {
					this.columnMaps = data.body.column;
					this.tables = data.body.table;
					this.loading = false;
				});

			},
			gen(v) {
				this.table = v;
				this.modalVisible = true;
				this.columns = this.columnMaps[v.tableName];
			},
			see(v) {
				this.$router.push({
					name: 'codeGeneratorMybatisTable',
					params: {table: v, column: this.columnMaps[v.tableName]}
				});
			}
		},
		mounted() {
			this.init();
		}
	};
</script>

<style scoped>
	.mybatis {
		padding: 20px;
	}

	.mybatis .table-list {
		margin-top: 15px;
	}
</style>