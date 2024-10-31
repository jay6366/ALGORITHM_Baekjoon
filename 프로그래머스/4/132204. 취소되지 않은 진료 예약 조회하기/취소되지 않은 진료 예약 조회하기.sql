--APNT_NO/PT_NAME/PT_NO/MCDP_CD/DR_NAME/APNT_YMD
--2022-04-13 취소되지 않은 흉부외과 진료 예약 내역
SELECT AP.APNT_NO, PT.PT_NAME, AP.PT_NO, AP.MCDP_CD,DR.DR_NAME, AP.APNT_YMD
FROM APPOINTMENT AP, PATIENT PT, DOCTOR DR
WHERE AP.PT_NO = PT.PT_NO
AND AP.MDDR_ID = DR.DR_ID
AND AP.MCDP_CD = 'CS'
AND AP.APNT_CNCL_YN = 'N'
AND TO_CHAR(AP.APNT_YMD,'YYYY-MM-DD') = '2022-04-13'
ORDER BY AP.APNT_YMD