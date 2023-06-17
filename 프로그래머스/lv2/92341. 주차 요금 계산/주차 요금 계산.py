from collections import defaultdict

def solution(fees, records):
    def calculate_parking_fee(min):
        fee = fees[1]
        
        if min <= fees[0]:
            return fee
        
        if (min - fees[0]) % fees[2] == 0:
            fee += fees[3] * (min - fees[0]) // fees[2]
        else:
            fee += fees[3] * ((min - fees[0]) // fees[2] + 1)
        
        return fee
    
    
    def convert_time_to_min(time):
        h, m = map(int, time.split(":"))
        return 60 * h + m
    
    
    def count_total_time():
        in_record = {}
        
        for r in records:
            time, car, action = r.split()
            if action == "IN":
                in_record[car] = convert_time_to_min(time)
            elif action == "OUT":
                total_min[car] += convert_time_to_min(time) - in_record.pop(car)
        
        for car in in_record:
            total_min[car] += convert_time_to_min("23:59") - in_record[car]
    
    
    result = []
    total_min = defaultdict(int)
    count_total_time()
    
    for car in sorted(total_min.keys()):
        result.append(calculate_parking_fee(total_min[car]))
        
    return result
    
        
    