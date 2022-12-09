package com.martin.orderMenu.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class Product {
	
	//產品
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;
	
	//產品名稱
	private String product_name;
	
	//產品版本
	private String product_version;
	
	//產品價格
	private String product_price;
	
	//產品狀態
	private int product_status;//0:關閉,1:開啟;
	
	//產品圖片
	private String product_img;
	
	//產品描述
	private String description;
	
	//產品排序
	private int product_priority;//1最前面
}
